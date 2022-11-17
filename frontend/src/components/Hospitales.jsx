import React, { useState, useEffect } from 'react';
import Service from '../service/service';
import Navbar from '../components/Navbar';
import '../styles/Hospital.css';

const Hospitales = () => {
    
    const [hospitales, setHospital] = useState([]);

    useEffect(() => {
        Service.getHospitales()
            .then(response => { 
                setHospital(response.data)
        }).catch(error => {
            console.log(error)
        })
    }, []
    );

    return (
        <>
            <div className="navbar">
                <Navbar/>
            </div> 
            <div className="hospitales-container">
                <div className='title-hospitales'>
                    Hospitales adheridos:
                </div>
                <div className='hospitales-box'>            
                    {hospitales.map((hospital, idx) => {          
                        return(
                            <div className="especialidad-container">
                                <div className="block-pad-hospital">
                                    <p className="hospital-name">{hospital.nombre}</p> 
                                </div>
                            </div>
                        )
                    })}
                </div>   
            </div>
        </>  
    );
  };
  
  export default Hospitales;