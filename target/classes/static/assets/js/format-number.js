function formaterNombre(nombre, decimales = 2, separateur = ',', separateurDecimal = '.') {
    // Convertir le nombre en chaîne et séparer la partie entière de la partie décimale
    const nombreString = nombre.toFixed(decimales).toString();
    const [partieEntiere, partieDecimale] = nombreString.split('.');

    // Ajouter les séparateurs de milliers à la partie entière
    const partieEntiereFormatee = partieEntiere.replace(/\B(?=(\d{3})+(?!\d))/g, separateur);

    // Retourner la version formatée du nombre
    return partieEntiereFormatee + (partieDecimale ? separateurDecimal + partieDecimale : '');
}