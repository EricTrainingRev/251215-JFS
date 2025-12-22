
/*
    here we are defining some interfaces to provide type safety and type hints for the data we are retrieving from the PokeAPI. Note that
    these types provide the structure for the specific data we want to retrieve from the API, it does not represent all the data we are
    getting from the API
*/
interface TypeData {
    type: {
        name:string
    }
}

interface MoveData {
    move: {
        name: string
    }
}

export interface PokemonData {
    name:string,
    sprites:{
        back_default:string,
        front_default: string
    },
    types: Array<TypeData>,
    moves: Array<MoveData>
}
