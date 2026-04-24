import { defineStore } from 'pinia'
import { fetchAlerts, fetchPrediction } from '../api/patrol'

export const useDashboardStore = defineStore('dashboard', {
  state: () => ({
    alerts: [],
    prediction: null,
    loading: false
  }),
  actions: {
    async loadAll() {
      this.loading = true
      try {
        const [alertsResp, predictResp] = await Promise.all([fetchAlerts(), fetchPrediction()])
        this.alerts = alertsResp.data
        this.prediction = predictResp.data
      } finally {
        this.loading = false
      }
    }
  }
})
