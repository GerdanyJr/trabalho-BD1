import './Form.css'
import { useState } from 'react'
import { createService } from '../../service/Request'

export function Form() {
  const [title, setTitle] = useState('')
  const [description, setDescription] = useState('')

  function handleChangeTitle (event: { target: { value: string } }) {
    setTitle(event.target.value)
  }
  function handleChangeDescription(event: { target: { value: string } }) {
    setDescription(event.target.value)
  }

  // eslint-disable-next-line @typescript-eslint/no-explicit-any
  function handleSubmit(event: any) {
    event.preventDefault
    createService(title, description)
    setTitle('')
    setDescription('')
  }

  return (
    <form className="formContainer" action="#" >
      <div className="inputContainer">
        <label htmlFor="title">Nome do serviço:</label>
        <input
          type="text"
          placeholder="Informe o nome do serviço"
          id="title"
          className="formInput"
          onChange={handleChangeTitle}
        />
      </div>
      <div className="inputContainer">
        <label htmlFor="description">Descrição do serviço:</label>
        <input
          type="text"
          placeholder="Descrição do serviço"
          id="description"
          className="formInput"
          onChange={handleChangeDescription}
        />
      </div>
      <button className="formButton" onClick={handleSubmit} type="reset">
        Salvar
      </button>
    </form>
  )
}
