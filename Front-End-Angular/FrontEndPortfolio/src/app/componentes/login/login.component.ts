import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticatorService } from 'src/app/services/authenticator.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form:FormGroup;
  constructor(private formBuilder:FormBuilder, private authenticatorService:AuthenticatorService, private ruta:Router) { 
    this.form=this.formBuilder.group(
      {
        user:['',[Validators.required,Validators.minLength(4)]],
        password:['',[Validators.required,Validators.minLength(6)]],
        deviceInfo:this.formBuilder.group(
          {
            deviceId: ["17867868768"],
            deviceType: ["DEVICE_TYPE_ANDRID"],
            notificationToken:["67657575eececc34"]
          })
      }
    )
  }

  ngOnInit(): void {
  }

  get User()
  {
    return this.form.get('user');
  }

  get Password()
  {
    return this.form.get('password');
  }

  onSend(event:Event)
  {
    event.preventDefault;
    this.authenticatorService.SessionStart(this.form.value).subscribe(data=>{
      this.ruta.navigate(['/portfolio/1'])
    })
  }

}
