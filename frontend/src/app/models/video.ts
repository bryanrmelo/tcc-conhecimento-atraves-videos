import { Playlist } from './playlist';
import { Usuario } from './usuario';
export class Video {

  titulo: string;
  link: string;
  autor: Usuario;
  privado: boolean;
  playlist: Playlist;
  categoria: string;
}
