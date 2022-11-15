import React, { useState } from "react"
import styled from 'styled-components'
import Modal from './Modal'
import Service from '../service/service'
import '../styles/TurnoModel.css'

const TurnoModel = (props) => {

  const { turno } = props
  const [stateModal, setStateModal] = useState(false);

  const deleteAccount = () => {
    Service.deleteTurno(turno.id)
    .then( _ => { 
      setStateModal(!stateModal)
      window.location.reload();  
    }).catch(error => {
      console.log(error)
    });
  };

  return (
      <>  
        <div className="turnoModel-container">
          <div className='card-turno'>
            <p className="value-turno" id="codigo"><strong>Codigo:</strong> {turno.id}</p> 
            <p className="value-turno"><strong>Fecha y Hora:</strong> {turno.fechaYHora}</p>
            <p className="value-turno" id="especialidad"><strong>Especialidad:</strong> {turno.especialidad}</p>
            <p className="value-turno"><strong>Profesional:</strong> {turno.especialista}</p>
            <p className="value-turno"><strong>Hospital:</strong> {turno.nombreHospital}</p>  
            <ContenedorBotones>
              <Boton onClick={() => setStateModal(!stateModal)}>Cancelar</Boton>
            </ContenedorBotones>      
            <Modal
              state={stateModal}
              setState={setStateModal}
              title="¿Desea cancelar su turno?"
              >
              <Contenido>
                <p className="message-modalCancelar"></p>
                <BotonesConfirmacion>
                  <Boton onClick={() => deleteAccount()}>Si</Boton>
                  <Boton onClick={() => setStateModal(!stateModal)}>No</Boton>
                </BotonesConfirmacion>
              </Contenido>
            </Modal> 
          </div>
        </div>
      </>
    );
};
  
export default TurnoModel;

  const ContenedorBotones = styled.div`
    display: flex;
    flex-wrap: wrap;
    justify-content:center;
    gap: 20px;
  `;
  
  const BotonesConfirmacion = styled.div`
    display: flex;
    flex-wrap: wrap;
    justify-content:center;
    margin-top: -20px;
  `;

  const Boton = styled.button`
    display: block;
    width: 70px;
    height: 30px;
    border-radius: 10px;
    color: #fff;
    border: none;
    margin: 5px;
    font-size: 12px;
    background: rgb(21, 16, 103);
    cursor: pointer;
    font-family: 'Roboto', sans-serif;
    font-weight: 500;
    transition: .3s ease all;
  `;

  const Contenido = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    h1 {
      font-size: 42px;
      font-weight: 700;
      margin-bottom: 10px;
    }
    p {
      font-size: 18px;
      margin-bottom: 20px;
    }
    img {
      width: 100%;
      vertical-align: top;
      border-radius: 3px;
    }
  `;