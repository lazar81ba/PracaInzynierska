import {UserGeneral} from './UserGeneral';
import {FacultyGeneral} from './FacultyGeneral';

export class Specialization {
  constructor(public id: number, public name: string, public users: UserGeneral[], public faculties: FacultyGeneral[]) {}
}
