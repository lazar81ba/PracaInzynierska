import {ProjectDetail} from '../ProjectDetail';
import {Link} from '../Link';
import {Tag} from '../Tag';

export class CreateProjectRequest {
  constructor(public name: string, public description: string, public imageURL: string,
              public publicProject: boolean, public projectDetails: ProjectDetail[],
              public links: Link[], public tags: Tag[]) {}
}
