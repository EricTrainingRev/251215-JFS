export interface PokemonData {
    name:string,
    sprites:{
        back_default:string,
        front_default: string
    },
    // NOTE: the typing below works, but we can make it easier to read/understand with more custom interfaces
    types: Array<{type:{name:string}}>,
    moves: Array<{move:{name: string}}>
}
