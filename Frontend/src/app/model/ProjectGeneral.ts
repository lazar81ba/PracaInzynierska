import {ProjectDetail} from './ProjectDetail';
import {Link} from './Link';
import {Tag} from './Tag';

export class ProjectGeneral {
  constructor(public id: number, public name: string, public description: string,
              public imageUrl: string, public publicProject: boolean, public projectDetails: ProjectDetail[],
              public links: Link[], public tags: Tag[]) {}
}
