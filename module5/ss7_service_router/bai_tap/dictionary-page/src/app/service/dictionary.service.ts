import { Injectable } from '@angular/core';
import {Iword} from '../model/iword';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  dictionaries: Iword[] = [{
    word: 'hello',
    mean: 'xin chào'
  }, {
    word: 'goodbye',
    mean: 'tạm biệt'
  }];
  constructor() { }

  getAll() {
    return this.dictionaries;
  }

  public findById(id: string) {
    return this.dictionaries.find(dictionariy => dictionariy.word === id);
  }
}
