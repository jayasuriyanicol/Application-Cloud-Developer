
import { Injectable } from '@angular/core';


// ?Dove effettivamnte il servizio verrà iniettato
@Injectable({

    providedIn: 'root'
})

export class ServiceProva {

    persone = [ 
        {nome:"Mario", cognome:"Mela", isOnline: true, color:'blue'},
        {nome:"Francesco", cognome:"Fiutini", isOnline: true, color:'green'},
        {nome:"Giacomo", cognome:"Coccodrillini", isOnline: false, color:'yellow'},
        {nome:"Carlo", cognome:"Conti", isOnline: true, color:'grey'},
        {nome:"Franco", cognome:"Tamburini", isOnline: false, color:'pink'},
    ]

    constructor (){ }


    getPersone(){
        return this.persone
    }
}



