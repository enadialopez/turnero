import React from 'react';
import { Link } from 'react-router-dom'; 
import '../styles/EspecialidadModel.css';

const EspecialidadModel = (props) => {

    const { especialidad, hospital} = props

    return (
        <div className="especialidad-container">
          <div className="block-pad block-btn-green">
            <Link to={`/hospital/${hospital.id}/${especialidad}/sacar-turno`} className="link">
              <p className="btn">{especialidad}</p> 
            </Link>
          </div>
        </div>
    );
  }

  export default EspecialidadModel;