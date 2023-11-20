import axios from "axios";
import { service } from "../types/service";

export async function getServices(){
    const response  = await axios.get("http://localhost:8080/serviço")
    const data:service[] = response.data
    return data
}

export async function createService(nome:string,descricao:string){
    if(nome !== "" && descricao !== ""){
        try {
            // eslint-disable-next-line @typescript-eslint/no-unused-vars
            const response  = await axios.post("http://localhost:8080/serviço", {
                "nome": nome,
                "descricao": descricao
            })
        } catch (error) {
            alert('Serviço já cadastrado')
        }
    } else {
        alert('Favor preencher todos os campos!')
    }

}

export async function deleteService(id:number){
    // eslint-disable-next-line @typescript-eslint/no-unused-vars
   const response = await axios.delete(`http://localhost:8080/serviço/${id}`)
}

export async function updateService(id:number, nome:string,descricao:string){
    const data = getServices()
    let errorControle = false;

    if(nome !== "" && descricao !== ""){
        for (const item of await data) {
            if(item.nome === nome){
                errorControle = true
            }
        }

        if(!errorControle) {
            // eslint-disable-next-line @typescript-eslint/no-unused-vars
            const response = await axios.patch(`http://localhost:8080/serviço/${id}`, {
                "nome": nome,
                "descricao": descricao,
            })
        } else {
            alert("Já existe um serviço com esse nome!")
        }
    }
    else {
        alert('Favor preencher todos os campos!')   
    }

    return errorControle
}


export async function searchService(title:string) {
    const data = getServices()
    for(const item of await data) {
        if(item.nome === title) {
             return item

        }
    }
}
