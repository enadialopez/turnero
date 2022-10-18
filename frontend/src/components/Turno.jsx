import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from "react-router-dom";
import Service from '../service/service';
import Navbar from '../components/Navbar';
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

    
    const navigate = useNavigate();
    const goHome = () => {
        navigate("/") ;
    };

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
        <>
            <div className="navbar">
                <Navbar/>
            </div> 
            <div className='turno-container'>
                <div className="title-turno">
                    <h1>Su turno ha sido confirmado</h1>
                </div>
                <div className="card-turno">
                    <div className="box-turno">
                        <div className="card-header">
                            <div className='header-left'>
                                <h2> {turno.nombreHospital} </h2>
                                <p>{turno.direccionHospital}</p>
                            </div>
                            <div className='header-right'>
                                <p>CÓDIGO DEL TURNO: {turno.id}</p>
                            </div>
                        </div>
                        <div className="card-body">
                            <div className="body-left">
                                    <p>FECHA: {turno.fechaYHora} </p>
                                    <p className='especialidad-turno'>ESPECIALIDAD: {turno.especialidad}</p>
                                    <p>PROFESIONAL: {turno.especialista}</p>
                                    <p className='fecha-turno'>FECHA EMITIDO: {turno.fechaEmitido}</p> 
                            </div>
                            <div className='body-right'>
                                    <p>SI NO PODES ASISTIR AL TURNO EN EL DIA Y 
                                        HORARIO ASIGNADO, POR FAVOR CANCELALO.</p>
                            </div>
                        </div>
                        <div className="footer">
                            <div className="paciente-date">
                                <p>PACIENTE: {turno.nombreYApellidoPaciente} </p>
                                <p>DNI: {turno.dniPaciente}</p>
                            </div>
                        </div>
                    </div>   
                </div>
                <div className='button'>
                    <button className="btn-mp" onClick={goHome} >Volver al inicio</button>
                </div>
            </div> 
        </> 
    );
  }
  
  export default Turno;