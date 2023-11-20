import { getServices } from '../../service/Request'
import { service } from '../../types/service'
import './Section.css'
import { SectionItem } from './SectionItem'
import { useEffect, useState } from 'react'

export function Section() {
  const [services, setServices] = useState<service[]>([])

  useEffect(() => {
    async function fetchItems() {
      const dados = await getServices()
      setServices(dados)
    }
    fetchItems();
  }, [services])

  return (
    <div>
      <div className="sectionHeader">
        <h2 className="header">Nome do serviço</h2>
        <h2 className="header">Descrição do serviço</h2>
      </div>
      <div>
        {services.map((item, i) => (
          <SectionItem data={item} key={i} />
        ))}
      </div>
    </div>
  )
}
