import React, { useState, useEffect }   from 'react';
import Service from '../Service/service';
import '../styles/EspecialidadModel.css';

const EspecialidadModel = (props) => {

    const { especialidad, hospital} = props

    const [turnos, setTurnos] = useState([]);
    const [especialidadSelected, setEspecialidadSelected] = useState ("");

    useEffect(() => {
        Service.getTurnosDisponiblesBy(hospital.id, especialidad)
            .then(response => { 
            setTurnos(response.data)
        }).catch(error => {
            console.log(error)
        });
    }, [especialidad, hospital]
    );

    return (
        <div className="especialidad-container">
                <div className="block-pad block-btn-green">
                <a type="button" className="btn" id="modal" data-toggle="modal" data-target="#exampleModalCenter" onClick={() => setEspecialidadSelected(especialidad)}>{especialidad}</a>
                <div className="modal fade" id="exampleModalCenter" tabIndex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                  <div className="modal-dialog modal-dialog-centered" role="document">
                    <div className="modal-content">
                      <div className="modal-header">
                        <h5 className="modal-title" id="exampleModalLongTitle">Reglas del juego</h5>
                        <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                        </button>
                      </div>
                      <div className="modal-body">
                      {turnos.map((turno, idx) => {          
                        <p>{turno.fechaYHora}</p>;
                        <p>hola</p>
                    })}
                      </div>
                      <div className="modal-footer">
                        <a type="button" className="btn-mp" data-dismiss="modal">Aceptar</a>
                      </div>
                    </div>
                  </div>
                </div>
            </div>
        </div>
    );
  }

  export default EspecialidadModel;