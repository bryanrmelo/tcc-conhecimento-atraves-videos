import { IUsuario } from './../../interfaces/IUsuario';
import { UsuarioService } from './../../services/usuario.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '@auth0/auth0-angular';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  formLogin!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private usuarioService: UsuarioService,
    public auth: AuthService
  ) {}

  ngOnInit(): void {
    this.criarForm();
  }

  criarForm() {
    this.formLogin = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      senha: ['', [Validators.required]],
    });
  }

  logar() {
    if (this.formLogin.invalid) return;
    var usuario = this.formLogin.getRawValue() as IUsuario;
    this.usuarioService.logar(usuario)
  }
}
