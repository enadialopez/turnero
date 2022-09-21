import React from "react";  
import { Link } from 'react-router-dom'; 
import '../styles/HospitalModel.css';

const HospitalModel = (props) => {

    const { hospital } = props

    console.log(hospital.especialidades) 

    return (
        <div className="hospitalModel-container">
            <Link to={`/hospital/search/${hospital.id}/especialidades`} className="link">
                <div className='box-description'>
                    <div className="name-selection">  
                        <p className="selection-name">{hospital.nombre}</p> 
                    </div>
                </div>
            </Link>
        </div>
    );
};
  
export default HospitalModel;