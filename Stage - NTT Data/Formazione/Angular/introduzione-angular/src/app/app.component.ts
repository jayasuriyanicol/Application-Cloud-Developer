import { OnInit,AfterViewInit, Component, ElementRef, signal, ViewChild, NgModuleRef } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {FormsModule} from '@angular/forms';
import { HighlightDirective } from './direttive/highlight.directive';
import { ServiceProva } from './service/service-prova';
import { AboutComponent } from './componenti/about/about.component';
import { ProvaComponent } from './provacomponent/provacomponent';
import { ContactComponent } from './componenti/contact/contact.component';
import { RouterLink } from '@angular/router';


@Component({

  selector: 'app-root',
  imports: [RouterOutlet,RouterLink, FormsModule, HighlightDirective, ProvaComponent,ContactComponent,AboutComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.css'
})

export class AppComponent implements OnInit,AfterViewInit{

@ViewChild('inputSaluti') valoreInput!: ElementRef<HTMLInputElement>;

constructor(private servizioProva: ServiceProva ){}

  colore = '';
  valore  =  'ciao a tutti';

  ngOnInit(): void {
    console.log('Componente inizializzato correttamente !');
    console.log(this.valoreInput);
    console.log('appcomponent', this.servizioProva.getPersone());
  }

  ngAfterViewInit():void {
    console.log('Siamo nella zonea di visualizzazione del dato')
    console.log(this.valoreInput);
  }

  OnClick() {
    console.log('Siamo nel click del bottone, sotto il valore ');
    console.log(this.valoreInput.nativeElement.value);  
  }



  cambiaColoreEvidenziatore(colore:string) {

    this.colore = colore;
  }


}
