import { Link } from "./link";

export class Usuario {

    id!: number;
    nome!: string;
    senha!: string;
    ativo!: boolean;
    _links!: Array<Link>[];
}
