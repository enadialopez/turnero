import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from "react-router-dom";
import Service from '../service/service';
import Navbar from '../components/Navbar';
import '../styles/FormTurno.css';

const FormTurno = () => {

    const { id, especialidad } = useParams();
    const navigate = useNavigate();

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
        hospital: "",
    })

    const [user, setUser] = useState ({
        idUser: "",
        nombreYApellidoUser: "",
        dniUser: "",
        telefonoUser: "",
        emailUser: "",
    })
    const [data, setData] = useState({
        to: "+541130457224",
        message: "Usted tiene un turno asignado",
    });
    
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
                    especialidad: turno.especialidad,
                    especialista: turno.especialista,
                    hospital: turno.hospital,
                })
            }
        });
    }; 
    const isLogged = !!localStorage.getItem("token");

    const changeHandler = (e) => {
        setFechaSeleccionada(e.target.value);
    };

    const handleChange = name => event => {
        setTurno(prevState => ({ ...prevState, [name]: event.target.value }));
    };

    useEffect(() => {
        if (isLogged){
          Service.getUser()
          .then(response => {
            setUser({
              idUser: response.data.id,
              nombreYApellidoUser: response.data.nombreYApellido,
              dniUser: response.data.dni,
              telefonoUser: response.data.telefono, 
              emailUser: response.data.email, 
            });
          }).catch(error => {
            console.log(error)
          });
        }}, [isLogged]
    ); 
    
    const handleSubmit = (event) => {
        console.log(turno.dniPaciente);
        console.log(user.dniUser)
        event.preventDefault();
        Service.putActualizarTurno(turno.id, turno).then(response => {
          setTurno((prevState)=>({
            ...prevState,
            nombreYApellidoPaciente: user.nombreYApellidoUser,
            dniPaciente: user.dniUser,
            telefonoPaciente: user.telefonoUser,
            emailPaciente: user.emailUser,
            }));
            navigate(`/hospital/turno/${turno.id}`);
        }).catch(err => console.log(turno.dniPaciente));
        
    };
    
    
     

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
            <div className="navbar">
                <Navbar/>
            </div> 
            <div className="formTurno-container">
                { isLogged 
                        ?
                        <>
                            <div className='form-content'>    
                                <form onSubmit={handleSubmit}>  
                                    <div className="select">
                                        <label for="Name">Turnos Disponibles:</label>
                                        <select id="select" value={fechaSeleccionada} onChange={changeHandler}>
                                            <option defaultValue="">Seleccione fecha y horario...</option>
                                            { fechasDisponibles().map (turno => {
                                                return (
                                                    <option onClick={() => setFechaSeleccionada(turno)} value={turno} selected={turno} required>{turno}</option>
                                                );
                                            })}
                                        </select>
                                    </div>
                                    <div className="turno-button-content">
                                        <button type="submit" className="btn-btn btn-info">Confirmar turno</button>
                                    </div>
                                </form>     
                            </div>     
                        </>    
                        :
                        <div className='card-notlogged'>
                            <p> Usted debe iniciar sesión para 
                                poder completar el formulario de turno</p>
                        </div>
                }
            </div>
        </>  
    );
  }
  
  export default FormTurno;