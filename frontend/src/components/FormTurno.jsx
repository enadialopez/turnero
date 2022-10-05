import React, { useState, useEffect } from 'react';
import { useParams } from "react-router-dom";
import Service from '../service/service';
import '../styles/FormTurno.css';

const FormTurno = () => {

    const { id, especialidad } = useParams();

    const [hospital, setHospital] = useState({
        id: "",
        nombre: "",
        direccion: "",
        municipio: "",
        especialidades: [],
    });
    const [turno, setTurno] = useState({
        id: "",
        nombreYApellidoPaciente: "",
        dniPaciente: "",
        telefonoPaciente: "",
        emailPaciente: "",
        fechaYHora: "",
        fechaEmitido: "",
        especialidad: "",
        especialista: "",
        nombreHospital: "",
        direccionHospital: "",
    })
    const [turnos, setTurnos] = useState([]);
    const [fechaSeleccionada, setFechaSeleccionada] = useState("");

    const fechasDisponibles = () => {
        let fechas = [];
        turnos.map( turno => fechas.push(turno.fechaYHora));
        return fechas;
    };

    const turnoByFecha = (fecha) => {
        turnos.forEach( turno => {
            if( turno.fechaYHora === fecha) {
                setTurno({
                    id: turno.id,
                    fechaYHora: turno.fechaYHora,
                    fechaEmitido: turno.fechaEmitido,
                    especialidad: especialidad,
                    especialista: turno.especialista,
                    nombreHospital: hospital.nombre,
                    direccionHospital: hospital.direccion,
                })
            }
        });
    }; 

    const changeHandler = (e) => {
        setFechaSeleccionada(e.target.value);
    };

    const handleChange = name => event => {
        setTurno(prevState => ({ ...prevState, [name]: event.target.value }));
    };
    
    const handleSubmit = (event) =>{
        event.preventDefault();
        //completar
      }

    useEffect(() => {
        Service.getHospitalById(id)
            .then(response => { 
                setHospital({
                    id: response.data.id,
                    nombre: response.data.nombre,
                    direccion: response.data.direccion,
                    municipio: response.data.municipio,
                    especialidades : response.data.especialidades
                  })      
        }).catch(error => {
            console.log(error)
        });
    }, [id]
    );

    useEffect(() => {
        Service.getTurnosDisponiblesBy(hospital.id, especialidad)
            .then(response => { 
            setTurnos(response.data)
        }).catch(error => {
            console.log(error)
        });
    }, [especialidad, hospital]
    );

    useEffect(() => {
        turnoByFecha(fechaSeleccionada);
    }, [fechaSeleccionada]
    );

    return (
        <>
            <div className="formTurno-container">
                <div className='form-content'>    
                    <form onSubmit={handleSubmit}>  
                        <div className="select">
                            <label for="Name">Turnos Disponibles:</label>
                            <select id="select" value={fechaSeleccionada} onChange={changeHandler}>
                                <option value="">Seleccione fecha y horario...</option>
                                { fechasDisponibles().map (turno => {
                                    return (
                                        <option onClick={() => setFechaSeleccionada(turno)} key={turno} value={turno} selected={turno} required>{turno}</option>
                                    );
                                })}
                            </select>
                        </div>
                        <div className="login-form-group">
                            <label for="Name">Nombre y Apellido:</label>
                            <input className="form-control" type="text" name="nombrePaciente" value={turno.nombreYApellidoPaciente} onChange={handleChange("nombreYApellidoPaciente")} placeholder="Nombre y Apellido" required />
                        </div>
                        <div className="login-form-group">
                            <label for="Name">DNI:</label>
                            <input className="form-control" type="text" name="dniPaciente" value={turno.dniPaciente} onChange={handleChange("dniPaciente")} placeholder="DNI" required />
                        </div>
                        <div className="login-form-group">
                            <label for="Name">Email:</label>
                            <input className="form-control" type="text" name="emailPaciente" value={turno.emailPaciente} onChange={handleChange("emailPaciente")} placeholder="Email" required />
                        </div>
                        <div className="login-form-group">
                            <label for="Name">Telefono:</label>
                            <input className="form-control" type="text" name="telefonoPaciente" value={turno.telefonoPaciente} onChange={handleChange("telefonoPaciente")} placeholder="Telefono / Celular" required />
                        </div>
                        <div className="turno-button-content">
                            <button type="submit" className="btn-btn btn-info">Confirmar turno</button>
                        </div>
                    </form>     
                </div>     
            </div>
        </>  
    );
  }
  
  export default FormTurno;