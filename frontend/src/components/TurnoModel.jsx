import React from "react";  
import '../styles/TurnoModel.css';

const TurnoModel = (props) => {

    const { turno } = props

    return (
        <div className="turnoModel-container">
            <div className='card-turno'>
                <p className="value-turno"><strong>Fecha y Hora:</strong> {turno.fechaYHora}</p>
                <p className="value-turno" id="especialidad"><strong>Especialidad:</strong> {turno.especialidad}</p>
                <p className="value-turno"><strong>Profesional:</strong> {turno.especialista}</p>
                <p className="value-turno"><strong>Hospital:</strong> {turno.nombreHospital}</p>    
                <p className="value-turno"><strong>FechaEmitido:</strong> {turno.fechaEmitido}</p>       
                <button type="button" className="button-turno" id="modal" data-toggle="modal" data-target="#exampleModalCenter">Cancelar</button>
                            <div className="modal fade" id="exampleModalCenter" tabIndex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                              <div className="modal-dialog modal-dialog-centered" role="document">
                                <div className="modal-content">
                                    <div className="modal-header">
                                      <p id="exampleModalLongTitle">¿Estas segura/o de cancelar este turno?</p>
                                    </div>
                                    <div className="modal-body-profile">
                                      <button className="btn-info b-profile" id='confirm'>Si, cerrar cuenta</button>
                                      <button className="btn-info b-profile" data-dismiss="modal" aria-label="Close">Cancelar</button> 
                                    </div>
                                </div>
                              </div>
                            </div>  
            </div>
        </div>
    );
};
  
export default TurnoModel;