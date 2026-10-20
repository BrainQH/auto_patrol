# 泵站AI智能巡检系统（Vue3 + Spring Boot + MyBatis-Plus + Swagger + TDengine + MySQL）

## 项目结构
- `backend`: Spring Boot 后端，提供巡检、安防、告警、设备控制、预测接口。
- `frontend`: Vue3 前端大屏框架，含巡检模式、布防控制、告警与预测展示。
- `sql`: MySQL 与 TDengine 建表语句。

## 核心能力对应
1. **智能识别监测**：后端 `recognition_event` 记录识别事件（格栅杂物、故障灯、安全帽、跌倒、周界入侵等）。
2. **布防撤防联动**：支持 3 秒撤防与 5-10 秒自动布防策略。
3. **自动巡检与报告**：支持主动/全站/例行/特殊天气巡检模式，巡检任务可扩展生成报告。
4. **设备运行控制**：接口可联动空调、风机、照明、抽水泵等设备。
5. **预测预警**：内置趋势预测示例，可接入 Python 模型或在 Spring Boot 内实现模型推理。

## 启动
### 后端
```bash
cd backend
mvn spring-boot:run
```
Swagger: `http://localhost:8080/swagger-ui.html`

### 前端
```bash
cd frontend
npm install
npm run dev
```
