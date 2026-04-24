import axios from 'axios'

const http = axios.create({ baseURL: '/api/v1' })

export const fetchAlerts = () => http.get('/alerts/latest')
export const fetchPrediction = () => http.get('/predict/trend')
export const startInspection = (payload) => http.post('/inspections/start', payload)
export const defenseAction = (payload) => http.post('/defense/action', payload)
export const controlDevice = (payload) => http.post('/devices/control', payload)
