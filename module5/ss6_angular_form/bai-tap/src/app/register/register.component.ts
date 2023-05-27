import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup, ValidationErrors, Validators} from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  rfRegister: FormGroup;
  countries: string[] = ['Da Nang', 'Quang Nam', 'Hue'];
  constructor() { }

  ngOnInit(): void {
    // @ts-ignore
    this.rfRegister = new FormGroup({
      email: new FormControl('', [Validators.email, Validators.required]),
      password: new FormControl('', [ Validators.required, Validators.minLength(6)]),
      confirmPass: new FormControl('', ),
      country: new FormControl('', [ Validators.required]),
      age: new FormControl('', [Validators.required, Validators.min(18)]),
      gender: new FormControl('', [Validators.required]),
      phone: new FormControl('', [Validators.pattern( /^\+84\d{9,10}$/), Validators.required])
    });
  }
}
