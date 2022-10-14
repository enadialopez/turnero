import React, { useState, useEffect } from 'react';
import { useParams } from "react-router-dom";
import Service from '../service/service';

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
        <>
            
        </>  
    );
  }
  
  export default Turno;