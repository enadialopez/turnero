import axios from "axios"

export const Service = {
    getHospitalById: function(id) {return axios.get(`http://localhost:8080/hospital/${id}`)},
    getSearch: function(data, select) {return axios.get(`http://localhost:8080/hospital/search?q=${data}&value=${select}`)},
    getTurnosDisponiblesBy(id, especialidad) {return axios.get(`http://localhost:8080/hospital/${id}/turnos/${especialidad}`)},
    getTurnoById: function(id) {return axios.get(`http://localhost:8080/turno/${id}`)},
    putTurno: function(id) {return axios.put(`http://localhost:8080/turno/${id}`)},
}

export default Service;
