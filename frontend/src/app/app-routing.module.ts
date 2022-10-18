import { AssistirComponent } from './components/video/assistir';
import { LoginComponent } from './components/login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { EnviarVideoComponent } from './components/video/enviar-video';
import { EnviarFonteComponent } from './components/fonte/enviar-fonte';

const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'sidebar', component: SidebarComponent },
  { path: 'login', component: LoginComponent },
  { path: 'video/enviar', component: EnviarVideoComponent},
  { path: 'fonte/enviar', component: EnviarFonteComponent},
  {
    path: 'video/assistir/:id',
    component: AssistirComponent,
    pathMatch: 'full',
  },
  { path: '**', redirectTo: '' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
