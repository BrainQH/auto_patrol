<script setup>
import { onMounted } from 'vue'
import { useDashboardStore } from '../stores/dashboard'
import { defenseAction, startInspection } from '../api/patrol'

const store = useDashboardStore()

const inspectionModes = [
  { code: 'ACTIVE', name: '主动巡检' },
  { code: 'FULL', name: '全站巡检' },
  { code: 'ROUTINE', name: '例行巡检' },
  { code: 'WEATHER', name: '特殊天气巡检' }
]

const quickStart = async (mode) => {
  await startInspection({ mode, routeCode: 'DEFAULT-ROUTE' })
  await store.loadAll()
}

const arm = async () => defenseAction({ action: 'ARM', delaySeconds: 8 })
const disarm = async () => defenseAction({ action: 'DISARM', delaySeconds: 3 })

onMounted(() => store.loadAll())
</script>

<template>
  <div class="screen">
    <header class="topbar">泵站AI智能巡检系统</header>
    <main class="grid">
      <section class="card">
        <h3>巡检模式</h3>
        <div class="btn-wrap">
          <button v-for="mode in inspectionModes" :key="mode.code" @click="quickStart(mode.code)">{{ mode.name }}</button>
        </div>
      </section>

      <section class="card">
        <h3>布防控制</h3>
        <div class="btn-wrap">
          <button @click="arm">立即布防</button>
          <button @click="disarm">进入作业撤防</button>
        </div>
        <p>默认支持 3 秒撤防，5-10 秒延迟布防。</p>
      </section>

      <section class="card alerts">
        <h3>实时告警</h3>
        <ul>
          <li v-for="item in store.alerts" :key="item.id">
            <b>[{{ item.level }}]</b> {{ item.category }} - {{ item.location }}
          </li>
        </ul>
      </section>

      <section class="card">
        <h3>预测预警</h3>
        <div v-if="store.prediction">
          <p>指标: {{ store.prediction.metric }}</p>
          <p>当前值: {{ store.prediction.current }}</p>
          <p>未来24h峰值: {{ store.prediction.next24hPeak }}</p>
          <p>风险: {{ store.prediction.riskLevel }}</p>
          <p>建议: {{ store.prediction.suggestion }}</p>
        </div>
      </section>
    </main>
  </div>
</template>
