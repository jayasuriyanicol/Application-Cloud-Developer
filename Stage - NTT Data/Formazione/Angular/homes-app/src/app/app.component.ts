import { Component,Input } from '@angular/core';
import { HomeComponent } from './home/home.component';  
import { HousingLocation } from './housing-location';

@Component({

  standalone: true,
  selector: 'app-root',
  template: `
   
  <main>
    <header class="brand-name">
      <img class="brand-logo" src="assets/logo.svg" alt="Logo" area-hidden="true">
    </header>
  </main>

  <section class="content"> 

    <app-home></app-home>
    
  </section>

  `,
  styleUrls: ['./app.component.css'],
  imports: [HomeComponent]

})
export class AppComponent {
  title = 'homes';
}
