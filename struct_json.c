/**
 * The contents of the file here for all intents of purpose
 * are to copy data from one text file into a structured xml
 * of key to value pairs.
 *
 * @author - Russell. A. E. Clarke
 * @date - 12/09/2022
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int main() {

    FILE *in;

    in = fopen("words_alpha.txt", "r");

    char buff[33];

    if (!in) {

        printf("Cannot open file %s \n", in);
        exit(0);

    } else {

        while (in != EOF && fgets(buff, 32, in) != NULL) {
            parser(&buff);
        }
    }

    fclose(in);

    return 0;
}

int parser(char *a) {

    FILE *json_dictionary = fopen("json_dictionary.xml", "w");

    fprintf(json_dictionary, "\"dictionary\"\:[{\n", "w");

    while (a != NULL) {

        fprintf(json_dictionary, "\t\t\"{%s\"\:\"%s\"}\,\n", a, a);
    }

    fprintf(json_dictionary, "]", "w");

    fclose(json_dictionary);

    return 0;
}
