import {UniversityGeneral} from './UniversityGeneral';
import {FacultyGeneral} from './FacultyGeneral';
import {SpecializationGeneral} from './SpecializationGeneral';
import {ProjectGeneral} from './ProjectGeneral';

export class User {
  constructor(public id: number, public name: string, public surname: string,
              public email: string, public imageUrl: string, public sex: string,
              public university: UniversityGeneral, public faculty: FacultyGeneral,
              public specialization: SpecializationGeneral, public participatedProjects: ProjectGeneral[],
              public observedProjects: ProjectGeneral[]) {}
}
