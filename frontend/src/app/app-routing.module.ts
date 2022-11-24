import { LoginComponent } from './components/login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { EnviarVideoComponent } from './components/video/enviar-video';
import { EnviarFonteComponent } from './components/fonte/enviar-fonte';
import { VideoComponent } from './components/video/video.component';

const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'sidebar', component: SidebarComponent },
  { path: 'login', component: LoginComponent },
  { path: 'video/enviar', component: EnviarVideoComponent},
  { path: 'fonte/enviar', component: EnviarFonteComponent},
  {
    path: 'video/:id',
    component: VideoComponent,
    pathMatch: 'full',
  },
  { path: '**', redirectTo: '' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
