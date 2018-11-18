import {Country} from './Country';
import {Faculty} from './Faculty';

export class University {
  constructor(public id: number, public name: string, public country: Country, public faculties: Faculty[]) {}
}
