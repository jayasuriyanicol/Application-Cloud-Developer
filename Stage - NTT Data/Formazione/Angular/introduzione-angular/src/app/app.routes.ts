import { Routes } from '@angular/router';
import { ProvaComponent } from './provacomponent/provacomponent';
import { AboutComponent } from './componenti/about/about.component';
import { ContactComponent } from './componenti/contact/contact.component';

export const routes: Routes = [
{ path: '', component: ProvaComponent },       
{ path: 'about', component: AboutComponent },   
{ path: 'contact', component: ContactComponent },
];
