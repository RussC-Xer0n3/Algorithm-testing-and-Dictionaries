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

        fclose(in);

    }

    return 0;
}

int parser(char *a) {

    FILE *dictionary = fopen("dictionary.xml", "a");

    for (int i = 0; i <= strlen(a)-1; i++) {
        fprintf(stdout, "<key_val\n");
        fprintf(stdout, "\t\tandroid:name=\"%s\"", a);
        fprintf(stdout, "\t\tandroid:value=\"%s\"", a);
        fprintf(stdout, "/>\n");
    }

    fclose(dictionary);

    return 0;
}
