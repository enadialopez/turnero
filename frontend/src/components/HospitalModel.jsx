import React from "react";  
import { Link } from 'react-router-dom'; 
import '../styles/HospitalModel.css';

const HospitalModel = (props) => {

    const { hospital, busqueda, value } = props

    return (
        <div className="hospitalModel-container">
            
                <div className='box-description'>
                    <div className="name-selection">  
                       { value === "nombre" || value === "municipio" ?
                           <Link to={`/hospital/${hospital.id}/especialidades`} className="link">
                                <p className="selection-name">{hospital.nombre}</p> 
                            </Link>
                        :    
                            <Link to={`/hospital/${hospital.id}/${busqueda}/sacar-turno`} className="link">
                                <p className="selection-name">{hospital.nombre}</p> 
                            </Link>
                        }   
                        
                    </div>
                </div>
            
        </div>
    );
};
  
export default HospitalModel;