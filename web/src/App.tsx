import './App.css'
import { SearchBar } from './components/SearchBar/SearchBar'
import {Form} from './components/Form/Form.tsx'
import { Section } from './components/Section/Section.tsx'

function App() {
  return (
    <>
      <h1>Serviços</h1>
      <SearchBar/>
      <Form/>
      <Section/>
    </>
  )
}

export default App
