import { Component, OnInit } from '@angular/core';
import {AuthapiService} from "../../services/authapi.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  message: any

  constructor(private service:AuthapiService) { }

  ngOnInit(): void {
  }

  loggingIn(){
    let outcome = this.service.login(this.username,this.password);
    outcome.subscribe(data=> {
      console.log(data)
    })
  }

}
