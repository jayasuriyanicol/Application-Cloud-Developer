import { AuthCallbackComponent } from './auth/auth-callback.component';
import { UserRouteAccessService } from './core/auth/user-route-access.service';
import { ErrorPageComponent } from './pages/error-page/error-page.component';
import { SchoolCalendarDetailComponent } from './pages/configurazioni/scuole/components/school-calendar-detail/school-calendar-detail.component';
import { HomepageComponent } from './pages/homepage/homepage.component';
import { GraduatorieListComponent } from './pages/graduatorie/graduatorie-list/graduatorie-list.component';
import { GraduatoriaCreateComponent } from './pages/graduatorie/graduatoria-create/graduatoria-create.component';




export const routes: Routes = [
    children: [
      { path: '', redirectTo: 'scuole', pathMatch: 'full' },
      { path: 'titoli-di-studio', component: GestioneSelectComponent, data: { breadcrumb: 'Gestione titoli di studio' } },
      { path: 'scuole', component: ScuoleListComponent, data: { breadcrumb: 'Gestione scuole' } }
      { path: 'scuole', component: ScuoleListComponent, data: { breadcrumb: 'Gestione scuole' } },

       // *Here the link in configurazione ROUTE, setted also the breadcrumb
      {
        path: 'school-calendars/:id',
        component: SchoolCalendarDetailComponent,
        data: { breadcrumb: 'Dettaglio Calendario Scolastico' }
      }

    ]