import React, { useState, useEffect } from 'react';
import { useParams } from "react-router-dom";
import Service from '../service/service';
import '../styles/Turno.css';

const Turno = () => {

    const { id } = useParams();
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

    useEffect(() => {
        Service.getTurnoById(id)
            .then(response => { 
                setTurno({
                    id: response.data.id,
                    nombreYApellidoPaciente: response.data.nombreYApellidoPaciente,
                    dniPaciente: response.data.dniPaciente,
                    telefonoPaciente: response.data.telefonoPaciente,
                    emailPaciente : response.data.emailPaciente,
                    fechaYHora: response.data.fechaYHora,
                    fechaEmitido: response.data.fechaEmitido,
                    especialidad: response.data.especialidad,
                    especialista: response.data.especialista,
                    nombreHospital: response.data.hospital.nombre,
                    direccionHospital: response.data.hospital.direccion,
                  })      
        }).catch(error => {
            console.log(error)
        });
    }, [id]
    );

    console.log(turno)

    return (
        <div>
            <div className="titulo">
                <h1>Su turno ha sido confirmado</h1>
            </div>
            <div className="card turno" >
                <div className="card-header row justify-content-between">
                    <div>
                        <h2> {turno.nombreHospital} </h2>
                        <p>{turno.direccionHospital}</p>
                    </div>
                    <div>
                        <p>CÓDIGO DEL TURNO: {turno.id}</p>
                    </div>
                </div>
                <div className="card-body">
                    <div className="row justify-content-around" >
                        <div>
                            <p>FECHA: {turno.fechaYHora} </p>
                            <p>ESPECIALIDAD: {turno.especialidad} </p>
                            <p>PROFESIONAL: {turno.especialista} </p>
                        </div>
                    <div>
                        <h5>SI NO PODES ASISTIR AL TURNO, <br/>EN EL DIA Y HORARIO ASIGNADO, 
                        <br/> POR FAVOR CANCELALO</h5>
                    </div>
                </div>
                <div className="paciente">
                    <p>PACIENTE: {turno.nombreYApellidoPaciente} </p>
                    <p>DNI: {turno.dniPaciente}</p>
                </div>
                    <footer className="blockquote-footer">
                        {turno.fechaEmitido}</footer>
            </div>
        </div>
    </div>  
    );
  }
  
  export default Turno;