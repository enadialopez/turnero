import React     from 'react'
import { useContext } from 'react';
import { Context } from './Contexto';

const ModalCancelarTurno = () => {

  const [contextState, setContextState] = useContext(Context);

  return ( 
    <>
      <div className='modalContainer' style={{ pointerEvents: contextState  ? 'auto' : 'auto',}}>
        <div className='modalHeader'>
          <p className='modal-title'>SIGN IN </p>
          <p className='modal-title' id='title-msg'>{contextState.message}</p> 
        </div>
        <div className='modalForm'>
          <form className='formModal'>
            <div className='modal-inputs'>
            
            </div>
            <button type="submit" className="btn-btn btn-info b-log">LOG IN</button>
          </form>
        </div>
        <div className='modalFooter'>
            Don't have an account? <p className='s-btn'>SIGN UP HERE</p>
        </div>
      </div>
    </>
  )
}
export default ModalCancelarTurno;