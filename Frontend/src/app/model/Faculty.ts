import {SpecializationGeneral} from './SpecializationGeneral';

export class Faculty {
  constructor(public id: number, public name: string, public specializations: SpecializationGeneral[]) {}
}
