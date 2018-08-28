import { Author } from "./author";
import { CoverLetter } from "./coverLetter";

export class Article{
    id:string;
    title: string;
    author: Author[];
    abstract: Abstract;
    paperType: string;
    reference: Reference[];
    chapter: Chapter[];
    keyword: string[];
    coverLetter: CoverLetter;
    pp: number;
    journalId: string;
}

export class Abstract{
    defaultAbstract: DefaultAbstract;
    freeAbstract: string;
}

export class DefaultAbstract{
    purpose: string;
    designMethodologyApproach: string;
    findings: string;
    researchLimitationsImplications: string;
    practicalImplications: string;
    originalityValue: string;
}

export class Reference{
}

export class Chapter{
    title: string;
    chapter: Chapter[];
    list: List;
    table: Table;
    figure: Figure;
    paragraph: string[];
}

export class List{
    imet: string[]
}

export class Figure{
    name: string;
    pic: string;
}

export class Table{
    row: Row[];
}

export class Row{
    columns: Column[];
}

export class Column{
    cell: string[]
}












