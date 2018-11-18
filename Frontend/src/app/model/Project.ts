import {Link} from './Link';
import {Tag} from './Tag';
import {ProjectDetail} from './ProjectDetail';
import {UserGeneral} from './UserGeneral';

export class Project {
  constructor(public id: number, public name: string, public description: string,
              public imageUrl: string, public publicProject: boolean, public projectDetails: ProjectDetail[],
              public links: Link[], public tags: Tag[], public participators: UserGeneral[]) {}
}
