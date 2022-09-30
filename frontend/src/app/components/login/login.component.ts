import { HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/models/usuario';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  formLogin!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private loginService: LoginService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.criarForm();
  }

  criarForm() {
    this.formLogin = this.formBuilder.group({
      nome: ['', [Validators.required]],
      senha: ['', [Validators.required]],
    });
  }

  logar() {
    if (this.formLogin.invalid) return;
    var usuario = this.formLogin.getRawValue() as Usuario;
    //usuario.ativo = true;
    console.log(usuario);
    console.log(JSON.stringify(usuario));
    if (
      this.loginService.logar(usuario).subscribe(
        () => {
          this.router.navigateByUrl('/');
        },
        (err) => {
          console.log(err);
        }
      )
    ) {
    }

    //this.router.navigateByUrl('/')
  }
}
