import {Component, OnInit} from '@angular/core';
import {Pet} from '../../interface/pet';

@Component({
  selector: 'app-pet',
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.css']
})
export class PetComponent implements OnInit {
  pet: Pet = {
    name: 'Dog',
    // tslint:disable-next-line:max-line-length
    image: 'https://tse1.mm.bing.net/th?id=OIP.g51IwrTD6O4cQLja_EZNUwHaEn&pid=Api&rs=1&c=1&qlt=95&w=150&h=93'
  };

  constructor() {
  }

  ngOnInit(): void {
  }

}
