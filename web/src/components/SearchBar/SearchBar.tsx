import "./SearchBar.css"
import { searchService } from "../../service/Request";
import { useState } from "react";
import { service } from "../../types/service";
import { SectionItem } from "../Section/SectionItem";

export function SearchBar(){
  const [itemTitle, setitemTitle] = useState('')
  const [item, setItem] = useState<service>({nome:"", id:0, descricao:""})

  function handleChangeTitle (event: { target: { value: string } }) {
    setitemTitle(event.target.value)
  }

    async function handleSubmit() {
      const response = await searchService(itemTitle)
      if(response !== undefined){
        setItem(response)
      }
    }

  function Card(){
    if(item.nome !== "") {
      return (
        <SectionItem data={item}/>
      )
    } else {
      return null
    }
  }


  return (
    <div>
      <div className="searchBar">
        <input type="text" placeholder="Informe o nome do serviço" className="searchInput" id="searchBar" onChange={handleChangeTitle}/>
        <button className="searchButton" onClick={handleSubmit}>search</button>
      </div>
        <div>
          <Card/>
        </div>
    </div>
  );
}