package com.gcr.datosmx.data.localdata

import com.gcr.datosmx.data.models.Place

class Museums {
    fun getMuseums(): List<Place> {
        return listOf(
            Place(
                19.43530068493585,
                -99.14135654922899,
                "Bellas Artes",
                "Palacio emblematico de la Ciudad de México, construido a principios del siglo XX",
                "https://centrourbano.com/revista/wp-content/uploads/shutterstock_1257468529-735x400.jpg"
            ),
            Place(
                28.639730343650587,
                -106.07383781599802,
                "Calabozo de Hildalgo",
                "",
                "https://chihuahuaestuyo.com/wp-content/uploads/2015/10/chihuahua_calabozo_hidalgo1.jpg"
            ),
            Place(
                25.67666382661493,
                -100.28273466136574,
                "Museo del Acero Horno 3",
                "fue diseñado por la compañía Arthur G. McKee & Co. de Cleveland, EUA. Su instalación comenzó en octubre de 1965 y fue puesto en operación en enero de 1968",
                "https://centrourbano.com/revista/wp-content/uploads/museohorno3.jpg"
            ),
            Place(
                22.138774645200336,
                -100.97064571665447,
                "Museo Leonora Carrigton S.P.",
                "Dedicado a la artista Leonora Carrington (Lancashire, Inglaterra, 1917- Ciudad de México, 2011) el recinto alberga una colección de escultura, litografía y dibujo.",
                "https://static.wixstatic.com/media/bd63ab_9e2fda9faaf84867b925bb5bc03534a8~mv2.jpg/v1/fill/w_980,h_653,al_c,q_85,usm_0.66_1.00_0.01/bd63ab_9e2fda9faaf84867b925bb5bc03534a8~mv2.webp"
            ),
            Place(
                21.077087952711107,
                -86.8461368,
                "Museo Subacuático de Arte",
                "Este espacio escultórico se ubica entre Cancún e Isla Mujeres. Además de ser un museo de arte, la intención fue regenerar parte del Arrecife Mesoamericano",
                "https://travesiasdigital.com/wp-content/uploads/2019/05/museo-subacuatico-cancun-768x576.jpg"
            ),
            Place(
                25.41451191703681,
                -100.96369333863427,
                "Museo del desierto",
                "Museo moderno de historia natural y regional, con esqueletos de dinosaurios, fósiles y un zoológico.",
                "https://lh5.googleusercontent.com/p/AF1QipM0RiOZEmqfBiX-DxZwzYMt25cmhqSlluvTCj7N=w426-h240-k-no"
            )


        )
    }
}