import { Usuario } from 'src/app/models/usuario';
import { Video } from './video';

export class Playlist {

  nome: string;
  videos: Array<Video>
  dono: Usuario;

}
