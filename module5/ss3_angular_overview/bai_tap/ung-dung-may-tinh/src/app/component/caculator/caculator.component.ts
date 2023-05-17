import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-caculator',
  templateUrl: './caculator.component.html',
  styleUrls: ['./caculator.component.css']
})
export class CaculatorComponent implements OnInit {
  result: number = undefined;

  constructor() { }

  ngOnInit(): void {
  }

  cong(firt: string, second: string) {
    this.result = +firt + +second;
  }

  tru(firt: string, second: string) {
    this.result = +firt - +second;
  }

  nhan(firt: string, second: string) {
    this.result = +firt * +second;
  }

  chia(firt: string, second: string) {
    this.result = +firt / +second;
  }
}
